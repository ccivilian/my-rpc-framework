package czihao.rpc.serializer;

/**
 * 通用的序列化反序列化接口
 * 注：序列化和反序列化的对象都是RpcRequest或RpcResponse
 */
public interface CommonSerializer {

    Integer KRYO_SERIALIZER = 0;
    Integer JSON_SERIALIZER = 1;
    Integer HESSIAN_SERIALIZER = 2;
    Integer PROTOBUF_SERIALIZER = 3;

    Integer DEFAULT_SERIALIZER = PROTOBUF_SERIALIZER;

    static CommonSerializer getByCode(int code) {
        switch (code) {
            case 0:
                return new KryoSerializer();
            case 1:
                return new JsonSerializer();
            case 2:
                return new HessianSerializer();
            case 3:
                return new ProtobufSerializer();
            default:
                return null;
        }
    }

    byte[] serialize(Object obj);

    Object deserialize(byte[] bytes, Class<?> clazz);

    int getCode();

}
