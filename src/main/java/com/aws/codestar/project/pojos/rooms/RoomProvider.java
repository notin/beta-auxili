package com.aws.codestar.project.pojos.rooms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import static com.aws.codestar.project.util.Helper.getUUID;
import static com.aws.codestar.project.util.JsonConverter.toJson;

@Data
@Entity
@Builder
public class RoomProvider{

	@JsonProperty("provider")
	@OneToMany
	private List<Room> provider;

	@Id
	@JsonProperty("id")
	private String id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("requesterId")
	private String requesterId;

	public  String getId()
	{
		this.id = id == null ? getUUID() : id;
		return id;
	}

	public void setId(String id)
	{ this.id = id == null ? getUUID() : id; }

	public List<Room> getProvider()
	{
		prepList();
		return provider;
	}

	public void setProvider( List<Room> rooms)
	{
		prepList();
		provider = rooms;
	}

	private void prepList()
	{
		boolean b = this.provider == null || provider.isEmpty();
		if(b)
		{
			this.provider = new ArrayList<>();
			provider.add(Room.builder().build());
		}
	}

	@Override
	public String toString()
	{
		return toJson(this);
	}
}