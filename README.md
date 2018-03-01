# camel-random-delayer

Little helper class for generating delays, used by Camel routes in ActiveMQ.

## Usage

First, build the extension, and get dependencies
```bash
$ gradle build && gradle getDeps
```

Then, copy both extension from `./build/libs` and dependencies from `./runtime` into 
`${ACTIVEMQ_HOME}/lib/optional`

Then, use it in your camel routes, like this:
```xml
<bean id="RandomDelay" class="pl.lichnerowicz.hcsvntdracones.RandomDelayer"/>

<camelContext id="camel" xmlns="http://camel.apache.org/schema/spring">
    <route>
        <description>Auto-Reply</description>
        <from uri="broker:queue:REQUEST"/>
        <delay>
            <method ref="RandomDelay" method="getPoisson(24, 60000)"/>
        </delay>
        <to uri="broker:queue:RESPONSE"/>
    </route>
</camelContext>
``` 
## License

- Unlicense (~Public Domain)

## Related Work
- [ActiveMQ](http://activemq.apache.org/)
- [Camel](http://camel.apache.org/)