package proto

import (
	"bufio"
	"bytes"
	"encoding/binary"
)

// (1) Encode 将消息编码
func Encode(message string) ([]byte, error) {
	// 1.读取消息的长度，转换成int32类型（占4个字节）以后可以按照需要进行自定义
	var length = int32(len(message))
	var pkg = new(bytes.Buffer) // 向系统为具有读写方法的字节大小可变的缓冲区申请内存。
	// 2.写入消息头
	err := binary.Write(pkg, binary.LittleEndian, length) //注意此处以小端的方式写入.在后续解包时也必须采用小端方式读取
	if err != nil {
		return nil, err
	}
	// 3.写入消息实体
	err = binary.Write(pkg, binary.LittleEndian, []byte(message))
	if err != nil {
		return nil, err
	}
	// 4.返回封包完毕的缓冲区中数据
	return pkg.Bytes(), nil
}

// (2) Decode 解码消息
func Decode(reader *bufio.Reader) (string, error) {
	// 1.读取消息的长度
	lengthByte, _ := reader.Peek(4)           // 读取前4个字节的数据
	lengthBuff := bytes.NewBuffer(lengthByte) // NewBuffer使用buf作为初始内容创建并初始化一个新缓冲区,此处指定要读取数据的长度.
	var length int32
	err := binary.Read(lengthBuff, binary.LittleEndian, &length)
	if err != nil {
		return "", err
	}
	// 2.Buffered返回缓冲中现有的可读取的字节数,如果获取的字节数小于消息的长度则说明数据包有误.
	if int32(reader.Buffered()) < length+4 {
		return "", err
	}

	// 3.读取真正的消息数据
	pack := make([]byte, int(4+length))
	_, err = reader.Read(pack)
	if err != nil {
		return "", err
	}

	// 4.利用slice切片返回四个字节后的消息数据
	return string(pack[4:]), nil
}
