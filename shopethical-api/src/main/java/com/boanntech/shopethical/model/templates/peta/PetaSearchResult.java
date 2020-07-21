package com.boanntech.shopethical.model.templates.peta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PetaSearchResult{

	@JsonProperty("label_clean")
	private String labelClean;

	@JsonProperty("link")
	private String link;

	@JsonProperty("label")
	private String label;

	@JsonProperty("id")
	private int id;

	@JsonProperty("type_label")
	private String typeLabel;

	@JsonProperty("type")
	private String type;

	@JsonProperty("value")
	private String value;

	public String getLabelClean(){
		return labelClean;
	}

	public String getLink(){
		return link;
	}

	public String getLabel(){
		return label;
	}

	public int getId(){
		return id;
	}

	public String getTypeLabel(){
		return typeLabel;
	}

	public String getType(){
		return type;
	}

	public String getValue(){
		return value;
	}
}