package com.vuln.platform.discovery;

import java.util.List;
import java.util.Map;

/**
 * Adapter 预置接口能力（目录项）。用户不可改 path/method；仅 {@code queryConfigurable=true} 的能力允许覆盖查询参数。
 */
public record AdapterCapability(
        String id,
        String name,
        String description,
        boolean fixed,
        boolean queryConfigurable,
        String httpMethod,
        String path,
        List<String> editableQueryParams,
        Map<String, Object> defaultQuery
) {
}
