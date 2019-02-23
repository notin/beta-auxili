package com.aws.codestar.project.pojos.conversation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

import static com.aws.codestar.project.util.Helper.getUUID;
import static com.aws.codestar.project.util.JsonConverter.toJson;

@Data
@Entity
@Builder
public class MessagesItem{

	@JsonProperty("timestamps")
	private String timestamps;

	@Id
	@JsonProperty("id")
	private String id = getUUID();

	@JsonProperty("message")
	private String message;

	@JsonProperty("user")
	private String user;

	public  String getId()
	{
		this.id = id == null ? getUUID() : id;
		return id;
	}

	public void setId(String id)
	{ this.id = id == null ? getUUID() : id; }

	@Override
	public String toString()
	{
		return toJson(this);
	}

}