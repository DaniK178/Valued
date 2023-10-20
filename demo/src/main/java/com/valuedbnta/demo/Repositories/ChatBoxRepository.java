package com.valuedbnta.demo.Repositories;

import com.valuedbnta.demo.Models.Chatbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatBoxRepository extends JpaRepository<Chatbox, Long> {
//sent obejct //conver
}
