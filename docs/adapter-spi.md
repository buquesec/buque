# 扫描工具 Adapter SPI

完整产品以 **安装包** 发布（功能齐全，不含全部源码）。本文件说明如何在私有/后续版本中扩展扫描工具对接。

实现 `com.vuln.platform.discovery.ToolAdapter`，以 Spring `@Component` 注册，并实现：

- `adapterCode()`：工具编码，与「工具实例」里的类型对应
- `validateConnection`：试连接
- `pull`：按 API 拉取发现；或覆盖 `parseFile` / `parseWebhook`

`AdapterCapability` 描述该工具预置的接口能力（路径、是否允许改查询参数），界面「接口能力」页只读展示。

公开仓只包含上述接口源码，不包含各厂商 Adapter 实现与平台其余业务。
