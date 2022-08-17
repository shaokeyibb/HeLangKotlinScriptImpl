# HeLangKotlinScriptImpl：何语言 Kotlin 脚本版

Next-Generation Cyber Programming Language from Li Tang, **with powerful JVM support**.

灵感：[kifuan/helang: 何语言，次世代赛博编程语言。 (github.com)](https://github.com/kifuan/helang)

## 介绍

您所熟悉的何语言，现已强势来到 JVM 平台！我们做到了与 JVM 平台的完全兼容，同时完全自研，源代码自主可控！这简直是太酷了，完全符合我对未来生活的想象。

## 使用方法

1. 拉取源代码

```shell
> git clone git@github.com:shaokeyibb/HeLangKotlinScriptImpl.git
```

2. 编译

```shell
> gradlew shadowJar
```

3. 运行

```shell
> java -jar .\build\libs\HeLangKotlinScriptImpl-1.0-SNAPSHOT-all.jar hello.he.kts
```

4. 添加 `-debug` 参数查看 Debug 信息，修改 `hello.he.kts` 为其他路径来执行其他的 He Lang 脚本

## 语法

基本语法请参见 [kifuan/helang: 何语言，次世代赛博编程语言。 (github.com)](https://github.com/kifuan/helang)

但是！出于一些赛博之力的限制，何语言 Kotlin 脚本版和何语言原版有些许差异：

- 首先，创建变量应当使用后置类型风格，就像友商 Kotlin 那样

- 我们使用 `createU8(size)` 函数创建 u8，而不是 `[size]`
- 所有 `|` 应当带上反引号 \`，即 \`|\`

最后，我们得到这样的代码：

```kotlin
val forceCon: u8 = createU8(68)

forceCon[1 `|` 2 `|` 6 `|` 7 `|` 11 `|` 52 `|` 57 `|` 58 `|` 65] = 10

print(forceCon)
```

输出：

```
[10, 10, 0, 0, 0, 10, 10, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 10, 10, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0]
```

更不可能的是，HeLangKotlinScriptImpl **完全兼容 JVM**（并不是基于 JVM，只是兼容，小心我告你），这意味着，你可以无缝切换到 HeLangKotlinScriptImpl 中，这太酷了对吗。

## 总结

Enjoy！

## 开源

HeLangKotlinScriptImpl is licensed under [WTFPL](LICENSE).

