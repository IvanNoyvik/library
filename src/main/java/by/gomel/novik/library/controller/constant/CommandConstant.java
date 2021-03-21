package by.gomel.novik.library.controller.constant;

public interface CommandConstant {

    String POSTFIX = ".jsp";
    String PREFIX = "/";

    String COMMAND_PATH = "by.gomel.novik.library.controller.commands.%sCommand";

    //command

    //todo
    //resp message
    String LOGIN_OK = "Hello ";
    String LOGIN_FAIL = "wrong log or pass";
    String REGISTRATION_FAIL = "registration fail";
    String REGISTRATION_OK = "You have successfully registered!";
    String ADD_ORDER_FAIL = "ADD_ORDER_FAIL";
    String ADD_ORDER_OK = "ADD_ORDER_OK";
    String RETURN_ORDER_FAIL = "RETURN_ORDER_FAIL";
    String RETURN_ORDER_OK = "RETURN_ORDER_OK";
    String SENT_MESSAGE_OK = "SENT_MESSAGE_OK";
    String SENT_MESSAGE_FAIL = "SENT_MESSAGE_FAIL";
    String ADD_BOOK_FAIL = "ADD_BOOK_FAIL";
    String ADD_BOOK_OK = "ADD_BOOK_OK";
    String ADD_AUTHOR_FAIL = "ADD_AUTHOR_FAIL";
    String ADD_AUTHOR_OK = "ADD_AUTHOR_OK";
    String ADD_GENRE_FAIL = "ADD_GENRE_FAIL";
    String ADD_GENRE_OK = "ADD_GENRE_OK";
    String CHANGE_STATUS_FAIL = "CHANGE_STATUS_FAIL";
    String CHANGE_STATUS_OK = "CHANGE_STATUS_OK";
    String DELETE_USER_FAIL = "DELETE_USER_FAIL";
    String DELETE_USER_OK = "DELETE_USER_OK";
    String EDIT_USER_OK = "EDIT_USER_OK";
    String EDIT_USER_FAIL = "EDIT_USER_FAIL";
    String EDIT_BOOK_OK = "EDIT_BOOK_OK";
    String EDIT_BOOK_FAIL = "EDIT_BOOK_FAIL";
    String BLOCK = "Your account is blocked";
    String UNKNOWN_COMMAND = "UNKNOWN_COMMAND";


    String ERROR_MESSAGE = "?error=true";




    //attributes
    // param
    String ID = "id";
    String COMMAND = "command";
    String FORWARD = "forward";


    String USER = "user";
    String USERS = "users";
    String USER_ID = "userId";
    String LOGIN = "login";
    String PASSWORD = "password";
    String NAME = "name";

    String MESSAGE = "message";
    String MESSAGES = "messages";

    String BOOKS = "books";
    String BOOK = "book";
    String BOOK_ID = "bookId";
    String TITLE = "title";
    String GENRE = "genre";
    String GENRES = "genres";
    String AUTHOR = "author";
    String AUTHORS = "authors";
    String QUANTITY = "quantity";
    String IMAGE = "image";
    String DESCRIPTION = "description";

    String ORDERS = "orders";
    String DAYS = "days";
    String CONTEXT = "context";

    String STATUS = "status";
    String OK = "OK";
    String LIMITED = "Limited";
    String LOCKED = "Locked";
    String DURATION = "duration";



    //JSP
    String MAIN_JSP = "main";
    String REGISTRATION_JSP = "registration";
    String LOGIN_JSP = "login";
    String PROFILE_JSP = "profile";
    String BOOK_JSP = "book";
    String BLOCK_JSP = "block";
    String ERROR_JSP = "error";
    String ADMIN_JSP = "admin";
    String EDIT_BOOK_JSP = "editBook";
    String ADD_BOOK_JSP = "addBook";


}
