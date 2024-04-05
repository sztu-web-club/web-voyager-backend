package io.github.sztuwebclub.webvoyager.domain.evaluationMachine;

/**
 * 评测结果枚举类型，表示评测机的状态。
 */
public enum JudgeResult {
    /** 通过 */
    Accepted,
    /** 编译中 */
    Compiling,
    /** 编译错误 */
    ComplieError,
    /** 内存超限 */
    MemoryLimitExceed,
    /** 输出超限 */
    OutputlimitExceed,
    /** 格式错误 */
    PresentationError,
    /** 运行中 */
    Running,
    /** 运行时错误 */
    RuntimeError,
    /** 系统错误 */
    SystemError,
    /** 时间超限 */
    TimelimitExceed,
    /** 等待中 */
    Waiting,
    /** 答案错误 */
    WrongAnswer

}
