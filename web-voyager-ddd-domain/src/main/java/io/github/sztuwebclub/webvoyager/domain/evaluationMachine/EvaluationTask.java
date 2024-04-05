package io.github.sztuwebclub.webvoyager.domain.evaluationMachine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 评测任务类，用于表示评测任务的信息。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationTask {

    /** 评测任务ID */
    private String taskId;

    /** 评测任务描述 */
    private String taskDescription;
}
