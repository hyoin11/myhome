package com.godcoder.myhome.service;

import com.godcoder.myhome.Repository.BoardRepository;
import com.godcoder.myhome.Repository.UserRepository;
import com.godcoder.myhome.model.Board;
import com.godcoder.myhome.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public Board save(String username, Board board){
        User user = userRepository.findByUsername(username);
        board.setUser(user);
        return boardRepository.save(board);
    }
}
