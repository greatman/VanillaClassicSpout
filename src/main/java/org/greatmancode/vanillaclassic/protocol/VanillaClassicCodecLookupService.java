package org.greatmancode.vanillaclassic.protocol;

import org.greatmancode.vanillaclassic.protocol.codec.IdentificationCodec;
import org.greatmancode.vanillaclassic.protocol.codec.LevelDataChunkCodec;
import org.greatmancode.vanillaclassic.protocol.codec.LevelFinalizeCodec;
import org.greatmancode.vanillaclassic.protocol.codec.LevelInitializeCodec;
import org.greatmancode.vanillaclassic.protocol.codec.PingCodec;
import org.greatmancode.vanillaclassic.protocol.codec.SetBlockClientCodec;
import org.spout.api.protocol.CodecLookupService;

public class VanillaClassicCodecLookupService extends CodecLookupService {
	public VanillaClassicCodecLookupService() {
			try {
				/* 0x00 */
				bind(IdentificationCodec.class);
				/* 0x01 */
				bind(PingCodec.class);
				/* 0x02 */
				bind(LevelInitializeCodec.class);
				/* 0x03 */
				bind(LevelDataChunkCodec.class);
				/* 0x04 */
				bind(LevelFinalizeCodec.class);
				/* 0x05 */
				bind(SetBlockClientCodec.class);
				/* 0x06 */
				bind(SetBlockServerCodec.class);
				/* 0x07 */
				bind(SpawnPlayerCodec.class);
				/* 0x08 */
				bind(PlayerPositionCodec.class);
				/* 0x09 */
				//bind(PositionOrientationCodec.class); Not needed apparently
				/* 0x0a */
				//bind(PositionUpdateCodec.class); Not needed apparently
				/* 0x0b */
				//bind(OrientationUpdateCodec.class); Not needed apparently
				/* 0x0c */
				bind(DespawnPlayerCodec.class);
				/* 0x0d */
				bind(MessageCodec.class);
				/* 0x0e */
				bind(DisconnectPlayerCodec.class);
				/* 0x0f */
				bind(UpdateUserTypeCodec.class);
			}  catch (Exception ex) {
				throw new ExceptionInInitializerError(ex);
			}
	}
}
