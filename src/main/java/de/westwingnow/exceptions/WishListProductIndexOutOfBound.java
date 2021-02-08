package de.westwingnow.exceptions;

public class WishListProductIndexOutOfBound extends Exception {

    public WishListProductIndexOutOfBound(String message) {
        super(message);
    }

    public WishListProductIndexOutOfBound(String message, Throwable cause) {
        super(message, cause);
    }
}