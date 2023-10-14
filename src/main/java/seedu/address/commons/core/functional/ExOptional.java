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

    private static final ExOptional<?> NONE = ExOptional.empty();

    public static <T> ExOptional<T> of(T value) {
        return new PresentExOptional<>(value);
    }

    public static <T> ExOptional<T> ofNullable(T value) {
        if (value == null) {
            return ExOptional.empty();
        } else {
            return new PresentExOptional<>(value);
        }
    }

    public static <T> ExOptional<T> empty() {
        @SuppressWarnings("unchecked")
        ExOptional<T> opt = (ExOptional<T>) NONE;
        return opt;
    }

    public abstract T get();

    public abstract <S, E extends Throwable> ExOptional<S> map(ExFunction<? super T, ? extends S, E> functer) throws E;

    public abstract <S> ExOptional<S> map(Function<? super T, ? extends S> functer);

    public abstract <S, E extends Throwable> ExOptional<S> flatMap(
            ExFunction<? super T, ? extends ExOptional<? extends S>, E> functer) throws E;

    public abstract <S> ExOptional<S> flatMap(Function<? super T, ? extends ExOptional<? extends S>> functer);

    public abstract ExOptional<T> filter(Predicate<? super T> predicate);

    public abstract T orElse(T other);

    public abstract T orElseGet(Supplier<? extends T> supplier);

    public abstract void ifPresent(Consumer<? super T> consumer);

    public abstract boolean isPresent();

    public abstract boolean isEmpty();

    /**
     * Nested static class that represents a value present
     *
     * @param <T> Type T
     */
    private static final class PresentExOptional<T> extends ExOptional<T> {

        private final T value;

        private PresentExOptional(T value) {
            this.value = value;
        }

        @Override
        public T get() {
            return value;
        }

        @Override
        public <S, E extends Throwable> ExOptional<S> map(ExFunction<? super T, ? extends S, E> functer) throws E{
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
            return;
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
