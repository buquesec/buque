package com.vuln.platform.discovery;

import com.vuln.platform.domain.ToolInstance;

import java.util.List;
import java.util.Map;

/**
 * 安全工具适配器 SPI。新增厂商实现本接口并以 {@code @Component} 注册即可。
 */
public interface ToolAdapter {

    String adapterCode();

    /** 关联来源类型编码：SAST / SCA / IAST / DAST 等；默认 SAST。 */
    default String supportedSourceType() {
        return "SAST";
    }

    void validateConnection(ToolInstance instance);

    /**
     * API 拉取原始发现。若 {@code suppliedPayloads} 非空，适配器可直接使用（试同步/联调）。
     */
    PullResult pull(ToolInstance instance, List<Map<String, Object>> suppliedPayloads);

    /**
     * 解析上传文件（SARIF / JSON 等）。默认不支持。
     */
    default PullResult parseFile(ToolInstance instance, byte[] content, String formatHint) {
        throw new UnsupportedOperationException(adapterCode() + " does not support FILE_IMPORT");
    }

    /**
     * 解析 Webhook 推送体。默认不支持。
     */
    default PullResult parseWebhook(ToolInstance instance, Map<String, String> headers, byte[] body) {
        throw new UnsupportedOperationException(adapterCode() + " does not support WEBHOOK");
    }

    /**
     * 列出远端可选项目（供编辑实例选择同步范围）。默认不支持。
     *
     * @return 每项至少含 {@code key}、{@code name}
     */
    default List<Map<String, Object>> listRemoteProjects(ToolInstance instance, String query) {
        throw new UnsupportedOperationException(adapterCode() + " does not support remote project listing");
    }

    /**
     * 预置接口能力目录（只读）。默认空列表。
     */
    default List<AdapterCapability> listCapabilities() {
        return List.of();
    }

    /**
     * 在远端创建项目（固定能力）。默认不支持。
     *
     * @return 至少含 {@code key}、{@code name}
     */
    default Map<String, Object> createRemoteProject(ToolInstance instance, String projectKey, String projectName) {
        throw new UnsupportedOperationException(adapterCode() + " does not support remote project creation");
    }

    record PullResult(List<Map<String, Object>> payloads, String cursor) {
    }
}
