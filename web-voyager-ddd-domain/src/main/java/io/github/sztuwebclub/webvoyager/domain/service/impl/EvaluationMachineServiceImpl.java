package io.github.sztuwebclub.webvoyager.domain.service.impl;

import io.github.sztuwebclub.webvoyager.domain.evaluationMachine.EvaluationMachine;
import io.github.sztuwebclub.webvoyager.domain.evaluationMachine.EvaluationTask;
import io.github.sztuwebclub.webvoyager.domain.evaluationMachine.JudgeResult;
import io.github.sztuwebclub.webvoyager.domain.service.EvaluationMachineService;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * EvaluationMachineService 接口的实现类。
 * 该类提供了注册、移除、获取、分配任务和更新评测机状态的方法。
 */
@Service
public class EvaluationMachineServiceImpl implements EvaluationMachineService {
    /**
     * 存储评测机的 Map
     */
    private static final Map<String, EvaluationMachine> evaluationMachines = new ConcurrentHashMap<>();

    @Autowired
    private ProblemServiceImpl problemService;

    /**
     * 注册评测机。
     *
     * @param machine 要注册的评测机。
     */
    @Override
    public void registerEvaluationMachine(EvaluationMachine machine) {
        evaluationMachines.put(machine.getUserId(), machine);
    }

    /**
     * 移除评测机。
     *
     * @param userId 评测机的用户ID。
     */
    @Override
    public void removeEvaluationMachine(String userId) {
        evaluationMachines.remove(userId);
    }

    /**
     * 获取所有评测机。
     *
     * @return 所有评测机的列表。
     */
    @Override
    public List<EvaluationMachine> getAllEvaluationMachines() {
        return new ArrayList<>(evaluationMachines.values());
    }

    /**
     * 分配任务给评测机。
     *
     * @param task   要分配的任务。
     * @param userId 评测机的用户ID。
     */
    @Override
    public void assignTaskToEvaluationMachine(EvaluationTask task, String userId) {
        EvaluationMachine machine = evaluationMachines.get(userId);
        if (machine != null) {
            Session session = machine.getSession();
            try {
                // 在此处将任务发送到评测机
                session.getBasicRemote().sendText(task.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 更新评测机状态。
     *
     * @param userId 评测机的用户ID。
     * @param status 要更新的状态。
     */
    @Override
    public void updateMachineStatus(String userId, JudgeResult status) {
        EvaluationMachine machine = evaluationMachines.get(userId);
        if (machine != null) {
            machine.setStatus(status);
        }
    }

}
