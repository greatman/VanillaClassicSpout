package org.greatmancode.vanillaclassic.protocol.msg;

public class LevelDataChunkMessage extends VanillaClassicMessage {

	private final byte percentComplete;
	private final short chunkLength;
	private final byte[] chunkData;

	public LevelDataChunkMessage(short chunkLength, byte[] chunkData, byte percentComplete) {
		this.chunkLength = chunkLength;
		this.chunkData = chunkData;
		this.percentComplete = percentComplete;
	}

	public byte getPercentComplete() {
		return percentComplete;
	}

	public short getChunkLength() {
		return chunkLength;
	}

	public byte[] getChunkData() {
		return chunkData;
	}
}
