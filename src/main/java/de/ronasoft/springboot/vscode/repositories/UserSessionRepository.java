package de.ronasoft.springboot.vscode.repositories;

import java.util.List;
import de.ronasoft.springboot.vscode.domain.UserSession;

/**
 * Repository für UserSessions * 
 */
public interface UserSessionRepository {
    UserSession save(UserSession userSession);
    UserSession findById(Long id);
    List<UserSession> findAll();
    void deleteById(Long id);

