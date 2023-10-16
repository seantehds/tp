package seedu.address.commons.core.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//@@author asdfghjklxd-reused
/**
 * Redefines the {@code Optional} class given to us in Java to allow methods to throw exceptions
 * and be caught by external methods.
 *
 * @param <T>
 */
public abstract class ExOptional<T> {
    /** Empty {@code ExOptional<T>} to be reused. **/
    private static final ExOptional<?> NONE = new EmptyExOptional<>();

    /**
     * Creates an {@code ExOptional} object.
     *
     * @param value Value to encapsulate
     * @param <T> Type T
     * @return {@code ExOptional<T>} object
     */
    public static <T> ExOptional<T> of(T value) {
        return new PresentExOptional<>(value);
    }

    /**
     * Creates an {@code ExOptional} object. If input is null, an empty ExOptional is returned.
     *
     * @param value Value to encapsulate
     * @param <T> Type T
     * @return {@code ExOptional<T>} object
     */
    public static <T> ExOptional<T> ofNullable(T value) {
        if (value == null) {
            return ExOptional.empty();
        } else {
            return new PresentExOptional<>(value);
        }
    }

    /**
     * Returns an empty {@code ExOptional} object.
     *
     * @param <T> Type T
     * @return Empty {@code ExOptional<T>} object
     */
    public static <T> ExOptional<T> empty() {
        @SuppressWarnings("unchecked")
        ExOptional<T> returnOptional = (ExOptional<T>) NONE;
        return returnOptional;
    }

    public abstract T get();

    /**
     * Maps the stored item of type T to item of type S.
     *
     * @param functer {@code ExFunction} object that converts an object of type T to type S
     * @param <S> Type S
     * @param <E> Type of exception to be thrown
     * @return {@code ExOptional<S>}
     * @throws E Exception thrown
     */
    public abstract <S, E extends Throwable> ExOptional<S> map(ExFunction<? super T, ? extends S, E> functer) throws E;

    /**
     * Maps the stored item of type T to item of type S.
     *
     * @param functer {@code ExFunction} object that converts an object of type T to type S
     * @param <S> Type S
     * @return {@code ExOptional<S>}
     */
    public abstract <S> ExOptional<S> map(Function<? super T, ? extends S> functer);

    /**
     * Flat Maps the stored item of type T to item of type S, using a function that generates
     * {@code ExOptional<S>} objects.
     *
     * @param functer {@code ExFunction} object that converts an object of type T to type S
     * @param <S> Type S
     * @param <E> Type of exception to be thrown
     * @return {@code ExOptional<S>}
     * @throws E Exception thrown
     */
    public abstract <S, E extends Throwable> ExOptional<S> flatMap(
            ExFunction<? super T, ? extends ExOptional<? extends S>, E> functer) throws E;

    /**
     * Flat Maps the stored item of type T to item of type S, using a function that generates
     * {@code ExOptional<S>} objects.
     *
     * @param functer {@code ExFunction} object that converts an object of type T to type S
     * @param <S> Type S
     * @return {@code ExOptional<S>}
     */
    public abstract <S> ExOptional<S> flatMap(Function<? super T, ? extends ExOptional<? extends S>> functer);

    /**
     * Filters the {@code ExOptional} object.
     *
     * @param predicate Predicate that checks if contained object meets the predicate criteria
     * @return true Empty {@code ExOptional} if predicate evaluates to false, else return this object
     */
    public abstract ExOptional<T> filter(Predicate<? super T> predicate);

    /**
     * Returns this {@code ExOptional}'s value, or the alternative input value.
     *
     * @param other Alternative input value
     * @return This value or alternative value
     */
    public abstract T orElse(T other);

    /**
     * Returns this {@code ExOptional}'s value, or the alternative input value produced by the {@code Supplier}.
     *
     * @param supplier Supplier of alternative input value
     * @return This value or alternative value
     */
    public abstract T orElseGet(Supplier<? extends T> supplier);

    /**
     * Check if this {@code ExOptional} is empty, and if not, consume the item stored in it
     * with the {@code Consumer}.
     *
     * @param consumer Consumer that consumes objects of type T
     */
    public abstract void ifPresent(Consumer<? super T> consumer);

    /**
     * Checks if a value is present.
     *
     * @return true if value is present, else false
     */
    public abstract boolean isPresent();

    /**
     * Checks if a value is absent.
     *
     * @return true if the value is absent, else false
     */
    public abstract boolean isEmpty();

    /**
     * Nested static class that represents a value present
     *
     * @param <T> Type T
     */
    private static final class PresentExOptional<T> extends ExOptional<T> {
        /** Value stored in this {@code PresentExOptional}. */
        private final T value;

        /**
         * Creates an instance of {@code PresentExOptional}.
         *
         * @param value Value to encapsulate
         */
        private PresentExOptional(T value) {
            this.value = value;
        }

        @Override
        public T get() {
            return value;
        }

        @Override
        public <S, E extends Throwable> ExOptional<S> map(ExFunction<? super T, ? extends S, E> functer) throws E {
            return ExOptional.of(functer.apply(this.value));
        }

        public <S> ExOptional<S> map(Function<? super T, ? extends S> functer) {
            return ExOptional.of(functer.apply(this.value));
        }

        @Override
        public <S, E extends Throwable> ExOptional<S> flatMap(
                ExFunction<? super T, ? extends ExOptional<? extends S>, E> functer) throws E {
            if (functer.apply(this.value) instanceof EmptyExOptional) {
                return ExOptional.empty();
            }

            return ExOptional.of(functer.apply(this.value).get());
        }

        @Override
        public <S> ExOptional<S> flatMap(Function<? super T, ? extends ExOptional<? extends S>> functer) {
            if (functer.apply(this.value) instanceof EmptyExOptional) {
                return ExOptional.empty();
            }

            return ExOptional.of(functer.apply(this.value).get());
        }

        @Override
        public ExOptional<T> filter(Predicate<? super T> predicate) {
            if (this.value != null && !predicate.test(this.value)) {
                return ExOptional.empty();
            }

            return this;
        }

        @Override
        public T orElse(T other) {
            return this.value;
        }

        @Override
        public T orElseGet(Supplier<? extends T> supplier) {
            return this.value;
        }

        @Override
        public void ifPresent(Consumer<? super T> consumer) {
            consumer.accept(this.value);
        }

        @Override
        public boolean isPresent() {
            return true;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }

    /**
     * Nested static class that represents an empty ExOptional.
     * @param <T> Type Parameter T
     */
    private static final class EmptyExOptional<T> extends ExOptional<T> {
        @Override
        public T get() {
            throw new IllegalStateException("Empty ExOptional does not contain anything!");
        }

        @Override
        public <S, E extends Throwable> ExOptional<S> map(ExFunction<? super T, ? extends S, E> functer) throws E {
            return ExOptional.empty();
        }

        @Override
        public <S> ExOptional<S> map(Function<? super T, ? extends S> functer) {
            return ExOptional.empty();
        }

        @Override
        public <S, E extends Throwable> ExOptional<S> flatMap(
                ExFunction<? super T, ? extends ExOptional<? extends S>, E> functer) throws E {
            return ExOptional.empty();
        }

        @Override
        public <S> ExOptional<S> flatMap(Function<? super T, ? extends ExOptional<? extends S>> functer) {
            return ExOptional.empty();
        }


        @Override
        public ExOptional<T> filter(Predicate<? super T> predicate) {
            return this;
        }


        @Override
        public T orElse(T other) {
            return other;
        }

        @Override
        public T orElseGet(Supplier<? extends T> supplier) {
            return supplier.get();
        }

        @Override
        public void ifPresent(Consumer<? super T> consumer) {
            // does not consume it
            return;
        }

        @Override
        public boolean isPresent() {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }
    }
}
//@@author
