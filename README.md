process to execute run commands in src\main

add protoc to src\main\

protoc.exe --proto_path=resources resources/Address.proto --java_out ./java
protoc.exe --proto_path=resources resources/Employee.proto --java_out ./java
protoc.exe --proto_path=resources resources/Employee1.proto --java_out ./java


