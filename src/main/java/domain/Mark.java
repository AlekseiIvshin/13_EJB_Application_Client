package domain;

import java.io.Serializable;

/**
 * @author Aleksei_Ivshin
 *
 */
public class Mark implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6437859440145961767L;

	private long id;

	private String name;

	private int deleted;

	protected short version;

	public Mark() {
	}

	public Mark(long id, String name) {
		this.id = id;
		this.name = name;
		this.deleted = 0;
	}

	public Mark(String name) {
		this.name = name;
		this.deleted = 0;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public short getVersion() {
		return version;
	}

	public void setVersion(short version) {
		this.version = version;
	}

}
