package io.github.sztuwebclub.webvoyager.domain.evaluationMachine;

import jakarta.websocket.Session;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 评测机类，用于表示评测机的信息。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationMachine {

    /** 评测机用户ID */
    private String userId;

    /** 评测机的WebSocket会话 */
    private Session session;

    /** 评测机的状态 */
    private JudgeResult status;
}
