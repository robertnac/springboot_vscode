package de.ronasoft.springboot.vscode.repositories;

import java.util.HashMap;
import java.util.Map;

public class UserSessionRepositoryMemory implements UserSessionRepository {
    private Map<String, String> sessions = new HashMap<>();

    @Override
    public void createSession(String userId, String sessionId) {
        sessions.put(userId, sessionId);
    }

    @Override
    public String getSession(String userId) {
        return sessions.get(userId);
    }

    @Override
    public void deleteSession(String userId) {
        sessions.remove(userId);
    }
}