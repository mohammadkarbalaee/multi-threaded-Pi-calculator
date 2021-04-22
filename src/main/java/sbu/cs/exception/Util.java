package sbu.cs.exception;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static final String COMMAND_LOGIN = "login";
    public static final String COMMAND_LOGOUT = "logout";
    public static final String COMMAND_SIGNUP = "signup";
    public static final String COMMAND_TIMELINE = "timeline";
    public static final String COMMAND_PROFILE = "profile";
    public static final String COMMAND_LIKE = "like";
    public static final String COMMAND_FOLLOW = "follow";
    public static final String COMMAND_UNFOLLOW = "unfollow";
    public static final String COMMAND_EXIT = "exit";
    public static final String NOT_IMPLEMENTED_COMMAND_BLOCK = "block";
    public static final String NOT_IMPLEMENTED_COMMAND_QUOTE = "quote";
    public static final String NOT_IMPLEMENTED_COMMAND_COMMENT = "comment";
    public static final String NOT_IMPLEMENTED_COMMAND_SEARCH = "search";

    public static List<String> getImplementedCommands() {
        return Arrays.asList(COMMAND_LOGIN,
                COMMAND_LOGOUT,
                COMMAND_SIGNUP,
                COMMAND_TIMELINE,
                COMMAND_PROFILE,
                COMMAND_LIKE,
                COMMAND_FOLLOW,
                COMMAND_UNFOLLOW,
                COMMAND_EXIT);
    }

    public static List<String> getNotImplementedCommands() {
        return Arrays.asList(
                NOT_IMPLEMENTED_COMMAND_BLOCK,
                NOT_IMPLEMENTED_COMMAND_QUOTE,
                NOT_IMPLEMENTED_COMMAND_COMMENT,
                NOT_IMPLEMENTED_COMMAND_SEARCH
        );
    }
}
