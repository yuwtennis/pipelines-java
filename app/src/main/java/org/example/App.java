/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.options.PipelineOptions;
import org.example.dags.Dag;

public class App {

    public static void main(String[] args) {
        DagType dagType = null;
        if (args.length > 0) {
            dagType = DagType.valueOf(args[0]);
        }

        PipelineOptions options = PipelineOptionsFactory.create();
        Pipeline p = Pipeline.create(options);

        Dag dag = Dispatcher.dispatch(dagType);
        dag.construct(p);

        p.run().waitUntilFinish();
    }
}
