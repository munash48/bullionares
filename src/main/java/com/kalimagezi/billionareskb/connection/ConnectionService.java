package com.kalimagezi.billionareskb.connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConnectionService {
	
	
	@Autowired
	private ConnectionRepository connectionRepository;

	public void addConnection(Connection connection) {

		connectionRepository.save(connection);
	}

	public Optional<Connection> getConnection(int id) {

		return connectionRepository.findById(id);

	}

	public List<Connection> getAllConnections() {

		List<Connection> connections = new ArrayList<>();
		connectionRepository.findAll().forEach(connections::add);
		return connections;

	}

	public void updateConnection(Connection connection) {

		connectionRepository.save(connection);
	}

	public void deleteConnection(int id) {
		connectionRepository.deleteById(id);

	}

}
