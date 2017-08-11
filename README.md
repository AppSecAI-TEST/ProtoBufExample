Google ProtoBuf Example

process to execute

add protoc to src\main\

execute following commands in src\main to generate classes
protoc.exe --proto_path=resources resources/Address.proto --java_out ./java
protoc.exe --proto_path=resources resources/Employee.proto --java_out ./java
protoc.exe --proto_path=resources resources/Employee1.proto --java_out ./java


