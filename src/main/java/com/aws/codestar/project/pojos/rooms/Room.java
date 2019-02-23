package com.aws.codestar.project.pojos.rooms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

import static com.aws.codestar.project.util.JsonConverter.toJson;

@Data
@Entity
@Builder
public class Room
{

	@JsonProperty("timestamps")
	private String timestamps;

	@JsonProperty("checkin time")
	private String checkinTime;

	@JsonProperty("available")
	private boolean available;

	@JsonProperty("location")
	private String location;

	@JsonProperty("userId")
	private String userId;

	@Id
	@JsonProperty("id")
	private String id;

	@Override
 	public String toString() { return toJson(this); }
}