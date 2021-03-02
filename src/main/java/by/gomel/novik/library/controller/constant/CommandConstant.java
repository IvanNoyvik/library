package by.gomel.novik.library.controller.constant;

public interface CommandConstant {

    String POSTFIX = ".jsp";
    String PREFIX = "/";

    String COMMAND_PATH = "by.gomel.novik.library.controller.commands.%sCommand";

    //command

    //MESSAGES and ERRORS
    String REGISTRATION_MESSAGE = "registration";
    String LOGIN_MESSAGE = "login";
    String ERROR_MESSAGE = "?error=true";





    //attributes
    // param
    String ID = "id";
    String COMMAND = "command";
    String FORWARD = "forward";
    String UNKNOWN = "unknown";
    String ERROR = "error";
    String USER = "user";
    String USER_ID = "userId";
    String LOGIN = "login";
    String PASSWORD = "password";
    String NAME = "name";
    String MESSAGE = "message";
    String BOOKS = "books";
    String BOOK = "book";
    String BOOK_ID = "bookId";
    String ORDERS = "orders";
    String DAYS = "days";
    String CONTEXT = "context";




    //JSP
    String MAIN_JSP = "main";
    String REGISTRATION_JSP = "registration";
    String LOGIN_JSP = "login";
    String PROFILE_JSP = "profile";
    String BOOK_JSP = "book";
    String BLOCK_JSP = "block";
    String ERROR_JSP = "error";

    String LOCKED = "locked";


}
