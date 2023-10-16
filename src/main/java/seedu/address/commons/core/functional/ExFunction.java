package seedu.address.commons.core.functional;

/**
 * Reused from https://stackoverflow.com/questions/27644361/how-can-i-throw-checked-exceptions-from
 * -inside-java-8-lambdas-streams
 *
 * @param <S> Input type
 * @param <T> Return type
 * @param <E> Exception thrown
 */
public interface ExFunction<S, T, E extends Throwable> {
    T apply(S s) throws E;
}
