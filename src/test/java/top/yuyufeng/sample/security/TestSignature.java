package top.yuyufeng.sample.security;


import org.junit.Test;
import top.yuyufeng.sample.security.rsa.RSASignature;

/**
 * 数字签名，保证消息没有被篡改
 */
public class TestSignature {
    private String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFPsX86sc4smp9YqcnFdXoXlqEaRebm7m90m8UZvYpa2aL69HANPta57Mhr97S+s7motS4kMx3mVOpv/nuNYihhHnN1MQ/RKtKT9bK1T7fPkn6vZ24kfQAsxvwz/7B7m+A0rAb0fJPX1YdZEzPgt//nVvl6eOhKPoxEK7A59bwyQIDAQAB";
    private String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIU+xfzqxziyan1ipycV1eheWoRpF5ubub3SbxRm9ilrZovr0cA0+1rnsyGv3tL6zuai1LiQzHeZU6m/+e41iKGEec3UxD9Eq0pP1srVPt8+Sfq9nbiR9ACzG/DP/sHub4DSsBvR8k9fVh1kTM+C3/+dW+Xp46Eo+jEQrsDn1vDJAgMBAAECgYEAgaUAUwPE7395aaJRbRAr3zne7LKsS7WLVgyoE7vSi556Wm4K2e8zGdITUxWhwrpSEcohG6uXpk7DPokSDxp7YuQWnOXXZvN+xMwKX7mrKyQulTkadHWHfHwr2aSoWsrjeujN+krgLlMkX13y4mmO6Td39IS7lG37sGSNPx5OyAECQQD6kkArOtGMnbKmeSCADCJyak5JdJ3LD4fdjp/u+hKO9ssVl+HaSTapvuuvpXogP0xQs5Hpv7WszRKRE0lT9qmBAkEAiCHLW6aewjgptE4hJqwphka/t6oneK3Ae0TBYFLimnAip96WWYtmLeZSSZrxWo+aT4DU7uaginGl78uAAqAbSQJARjBtlS52wIL0JjnL5tJ/W7l3kJAAG3+QOXnYRyL5y95J6RSQiYr0qvv2HU+nNB1HDVwfxXCUPYF8b/MNGV4BAQJAS1GHVjol9Idma6Aer2rpvqU+RbwbAqX/rTQpWcYCIjiQtBhvTzPVYOfh91+G0fhKBFrfdR6dDHw8tyP8u3ciIQJACsfWYia5DiD9psBcfBPTG30yxHqQVSZze10jvoHWP+X5L6WFJYnAOpFU7r7ndGIh9CtFnpYdAIJunaDgHdidnw==";

    /**
     *
     */
    @Test
    public void testEncryptByPrivateKey() {
        //发送信息
        String sign = RSASignature.sign("test", privateKey);
        System.out.println("sign:" + sign);

        //接收信息
        boolean res = RSASignature.doCheck("test", sign, publicKey);
        System.out.println(res);
    }

    /**
     *
     */
    @Test
    public void testEncryptByPublicKey() {
        //发送信息
        String sign = RSASignature.sign("test", publicKey);
        System.out.println("sign:" + sign);

        //接收信息
        boolean res = RSASignature.doCheck("test", sign, privateKey);
        System.out.println(res);
    }
}
