package com.learning.taskmanager.service;

import com.learning.taskmanager.entity.User;
import com.learning.taskmanager.entity.UserProfile;
import com.learning.taskmanager.repository.UserProfileRepository;
import com.learning.taskmanager.repository.UserRepositoty;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    private final UserRepositoty userRepositoty;
    private final UserProfileRepository userProfileRepository;

    public UserProfileService(UserRepositoty userRepositoty, UserProfileRepository userProfileRepository) {
        this.userRepositoty = userRepositoty;
        this.userProfileRepository = userProfileRepository;
    }

    public  Long createUserWithProfile(){
        User user=new User("Maria","maria@gamil.com");
        userRepositoty.save(user);

        UserProfile profile=new UserProfile("java backend developer","3456789");
        user.setProfile(profile);
        userProfileRepository.save(profile);

        return user.getId();
    }

   public Long createUserWithCascade(){

        User user=new User("Andrei","andrei@example.com");

        UserProfile profile=new UserProfile("Spring developer","3456789");

        user.setProfile(profile);
        userRepositoty.save(user);
        return user.getId();
   }
}
