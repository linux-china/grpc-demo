package org.mvnsearch.service.loadbalance;

import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * Rsocket name resolver
 *
 * @author linux_china
 */
public class RSocketNameResolver extends NameResolver {

    public RSocketNameResolver(URI targetUri) {
        //connect with rsocket
        System.out.println(targetUri);
    }

    @Override
    public String getServiceAuthority() {
        return "";
    }

    @Override
    public void start(Listener listener) {
        SocketAddress address = new InetSocketAddress("127.0.0.1", 50051);
        List<EquivalentAddressGroup> addressGroup = Arrays.asList(new EquivalentAddressGroup(Arrays.asList(address)));
        listener.onAddresses(addressGroup, Attributes.EMPTY);
    }

    @Override
    public void start(Listener2 listener) {
        SocketAddress address = new InetSocketAddress("127.0.0.1", 50051);
        List<EquivalentAddressGroup> addressGroup = Arrays.asList(new EquivalentAddressGroup(Arrays.asList(address)));
        ResolutionResult resolutionResult = ResolutionResult.newBuilder().setAddresses(addressGroup).build();
        listener.onResult(resolutionResult);
    }

    @Override
    public void refresh() {
        super.refresh();
    }

    @Override
    public void shutdown() {

    }
}
