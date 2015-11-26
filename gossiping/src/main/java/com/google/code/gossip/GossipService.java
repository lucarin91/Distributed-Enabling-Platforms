package com.google.code.gossip;

import java.net.*;
import java.util.*;

import org.apache.log4j.Logger;

import com.google.code.gossip.event.GossipListener;
import com.google.code.gossip.manager.GossipManager;
import com.google.code.gossip.manager.random.RandomGossipManager;

/**
 * This object represents the service which is responsible for gossiping with
 * other gossip members.
 */
public class GossipService
{
	public static final Logger LOGGER = Logger.getLogger(GossipService.class);

	private GossipManager _gossipManager;

	/**
	 * Constructor with the default settings.
	 *
	 * @throws InterruptedException
	 * @throws UnknownHostException
	 */
	public GossipService(StartupSettings startupSettings) throws InterruptedException, UnknownHostException
	{
		String myIp = InetAddress.getLocalHost().getHostAddress();
		try {
			Enumeration<NetworkInterface> b = NetworkInterface.getNetworkInterfaces();
			while (b.hasMoreElements()) {
				for (InterfaceAddress f : b.nextElement().getInterfaceAddresses())
					if (f.getAddress().isSiteLocalAddress())
						myIp = f.getAddress().getHostAddress();
			}
		} catch (SocketException e) {}
		System.out.println(myIp);
		_gossipManager = new RandomGossipManager(myIp,
																						 startupSettings.getPort(),
																						 "",
																						 startupSettings.getGossipSettings(),
																						 startupSettings.getGossipMembers(),
																						 null);
	}

	/**
	 * Setup the client's lists, gossiping parameters, and parse the startup
	 * config file.
	 *
	 * @throws InterruptedException
	 * @throws UnknownHostException
	 */
	public GossipService(String ipAddress, int port, String id, int logLevel,
						 List<GossipMember> gossipMembers, GossipSettings settings, GossipListener listener) throws InterruptedException, UnknownHostException
	{
		_gossipManager = new RandomGossipManager(ipAddress, port, id, settings, gossipMembers, listener);
	}

	public void start()
	{
		_gossipManager.start();
	}

	public void shutdown()
	{
		_gossipManager.shutdown();
	}

	public GossipManager get_gossipManager()
	{
		return _gossipManager;
	}

	public void set_gossipManager(GossipManager _gossipManager)
	{
		this._gossipManager = _gossipManager;
	}
}
