## Launching Hadoop jobs from the command line

+ [Optional] If you wrote the Hadoop program on a local machine. you should copy the jar file of your job to the Hadoop machine (let's call it `machine`)

		scp jarFile hadoop@machine:~/

    and SSH to `machine`:

		ssh hadoop@machine

+ Launch the job:

		hadoop jar jarFile.jar {class.name.with.package} [job args]

    Note that if the output directory exists (assuming you never want to overwrite it) you need to remove it *explicitely*:

	hadoop dfs -rmr output

    where the `-rmr` removes recursively the `output` directory, i.e., with all sub-directories.
    
    ### Example:

        hadoop jar it.cnr.isti.pad.WordCount /user/hadoop/snippets/ output
