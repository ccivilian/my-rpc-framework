package czihao.rpc.registry;

import com.alibaba.nacos.api.exception.NacosException;
import czihao.rpc.enumeration.RpcError;
import czihao.rpc.exception.RpcException;
import czihao.rpc.util.NacosUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * Nacos服务注册中心
 * 供服务提供者使用
 */
public class NacosServiceRegistry implements ServiceRegistry {

    private static final Logger logger = LoggerFactory.getLogger(NacosServiceRegistry.class);

    /*
     * 仅在AbstractRpcServer.publishService(T service, String serviceName)这一处被调用过
     * */
    @Override
    public void register(String serviceName, InetSocketAddress inetSocketAddress) {
        try {
            NacosUtil.registerService(serviceName, inetSocketAddress);
        } catch (NacosException e) {
            logger.error("注册服务时有错误发生:", e);
            throw new RpcException(RpcError.REGISTER_SERVICE_FAILED);
        }
    }

}
