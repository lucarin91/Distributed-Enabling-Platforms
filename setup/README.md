Hadoop Instructions
===================

Generally Hadoop can be run in three modes.
1. **Standalone (or local) mode**: There are no daemons used in this mode. Hadoop uses the local file system as an substitute for HDFS file system. The jobs will run as if there is 1 mapper and 1 reducer.2. **Pseudo-distributed mode**: All the daemons run on a single machine and this setting mimics the behavior of a cluster. All the daemons run on your machine locally using the HDFS protocol. There can be multiple mappers and reducers.3. **Fully-distributed mode**: This is how Hadoop runs on a real cluster.

In this section we will show you how to run Hadoop jobs in Standalone mode (very useful for developing and debugging) and also in Pseudo-distributed mode (to mimic the behavior of a cluster environment).

# Hadoop Installation

First of all, we need to setup an HADOOP installation to work with. 
We will review two different Hadoop deployments:

1. By using a [virtual machine environment](./vme.md) on your local machine. This deployment will be the main one used during lectures, as it provides a fully-configured virtual machine running Linux, with Hadoop software stack pre-installed and configured, and with the Eclipse IDE ready to be used to write, compile, debug and execute a simple Hadoop programs. 
2. By setting up a [pseudo-distributed cluster](./pdm.md) on your local machine. This deployment is used to learn how the Hadoop basic components must be installed and configured on a single machine, and how to execute simple Hadoop programs on top of it.

For an easy way to set up a cluster, try [Cloudera Manager](http://archive.cloudera.com/cm5/installer/latest/cloudera-manager-installer.bin) at your own risk on your own cluster. :wink:

# 