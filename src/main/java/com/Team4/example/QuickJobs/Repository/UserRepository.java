package com.Team4.example.QuickJobs.Repository;

import com.Team4.example.QuickJobs.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
