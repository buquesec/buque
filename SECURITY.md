# 安全披露

请**不要**在公开 Issue 里报告未修复的安全漏洞。

请发邮件至 **buquesec@163.com**。若同时使用 GitHub，可通过 Private Vulnerability Advisory 提交。Gitee 公开仓请不要开 Issue 报未修复漏洞。

请尽量包含：

- 影响的模块与版本（commit / tag）
- 复现步骤
- 预期影响（未授权访问、注入、越权等）

我们会在确认后修复并视情况发布说明。

## 部署注意

- 演示账号仅供本地试用，生产必须改密并限制网段。
- `application-test.yml` 中的许可证 AES 口令、更新 HMAC、数据库默认口令是**本地演示值**，不能用于生产。登录**不依赖**授权文件；测试密钥若被用来签发 `.lic`，也只影响授权展示，不作为访问控制。
- 生产请设置 `VULN_LICENSE_AES_KEY`、`VULN_UPDATE_HMAC_KEY`、`VULN_PG_PASSWORD`，以及大模型 `VULN_AI_API_KEY`。不要把真实密钥写进仓库或截图。
