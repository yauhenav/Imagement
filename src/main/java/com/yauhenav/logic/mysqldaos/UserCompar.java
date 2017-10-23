package com.yauhenav.logic.mysqldaos;

import java.util.Comparator;
import com.yauhenav.logic.dto.User;

/**
 * Created by yauhenav on 21.10.17.
 */
public class UserCompar implements Comparator<User> {
    public int compare(User a, User b) {
        return a.getId() - b.getId();
    }
}
