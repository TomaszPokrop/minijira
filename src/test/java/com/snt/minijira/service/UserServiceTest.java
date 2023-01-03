package com.snt.minijira.service;
import com.snt.minijira.model.User;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


class UserServiceTest {



    @Test
    void shouldAddUser() {
//        given
        UserService userService = mock(UserService.class);
        given(userService.addUser(Mockito.any(User.class))).willReturn(new User(1L, "user1", "user2", null));
//        when
        User user = userService.addUser(new User());
//        then
        Assert.assertEquals(user.getName(), "user1");


    }

    @Test
    void shouldGetAllUsers() {
//        given
        UserService userService = mock(UserService.class);
        given(userService.findAllUsers()).willReturn(prepareMockData());
//        when
        List<User> users = userService.findAllUsers();
//        then
        MatcherAssert.assertThat(users, Matchers.hasSize(2));

    }

    @Test
    void findUserById() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    private List<User> prepareMockData() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "user1", "user2", null));
        users.add(new User(2L, "user2", "user2", null));
        return users;
    }
}