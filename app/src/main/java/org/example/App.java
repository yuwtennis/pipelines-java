/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.options.PipelineOptions;
import org.example.dags.Dag;

public class App {

    public interface DagOptions extends PipelineOptions {
        @Description("Dag options")
        @Default.String("HELLOWORLD")
        String getDagType();
        void setDagType(String dagType);

        @Description("Backtracked years")
        @Default.Integer(3)
        int getBacktrackedYears();
        void setBacktrackedYears(int dagType);
    }
    public static void main(String[] args) {
        DagOptions options = PipelineOptionsFactory
                .fromArgs(args)
                .withValidation()
                .as(DagOptions.class);
        Pipeline p = Pipeline.create(options);

        Dag dag = DagDispatcher.dispatch(DagType.valueOf(options.getDagType()));
        dag.process(p);
    }
}
