/**
 * 评测机服务接口，用于管理评测机的注册、移除、获取以及任务分配和状态更新。
 */
package io.github.sztuwebclub.webvoyager.domain.service;

import io.github.sztuwebclub.webvoyager.domain.evaluationMachine.EvaluationMachine;
import io.github.sztuwebclub.webvoyager.domain.evaluationMachine.EvaluationTask;
import io.github.sztuwebclub.webvoyager.domain.evaluationMachine.JudgeResult;

import java.util.List;

public interface EvaluationMachineService {
    /**
     * 注册评测机。
     * @param machine 要注册的评测机对象
     */
    void registerEvaluationMachine(EvaluationMachine machine);

    /**
     * 移除评测机。
     * @param userId 要移除的评测机用户ID
     */
    void removeEvaluationMachine(String userId);

    /**
     * 获取所有评测机。
     * @return 所有评测机列表
     */
    List<EvaluationMachine> getAllEvaluationMachines();

    /**
     * 分配任务给评测机。
     * @param task 要分配的评测任务
     * @param userId 评测机用户ID
     */
    void assignTaskToEvaluationMachine(EvaluationTask task, String userId);

    /**
     * 更新评测机状态。
     * @param userId 评测机用户ID
     * @param status 新的评测机状态
     */
    void updateMachineStatus(String userId, JudgeResult status);


}
