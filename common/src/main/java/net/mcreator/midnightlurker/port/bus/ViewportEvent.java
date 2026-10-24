package net.mcreator.midnightlurker.port.bus;

import net.minecraft.client.Camera;
import net.minecraft.world.level.material.FogType;

public abstract class ViewportEvent extends Event {
	private final Camera camera;
	private final double partialTick;

	protected ViewportEvent(Camera camera, double partialTick) {
		this.camera = camera;
		this.partialTick = partialTick;
	}

	public Camera getCamera() {
		return this.camera;
	}

	public double getPartialTick() {
		return this.partialTick;
	}

	/** The fog distances (1.21.6+: per fog type, the terrain fog is FogType.ATMOSPHERIC); listeners change them */
	public static class RenderFog extends ViewportEvent {
		private final FogType type;
		private float nearPlaneDistance;
		private float farPlaneDistance;

		public RenderFog(FogType type, Camera camera, double partialTick, float near, float far) {
			super(camera, partialTick);
			this.type = type;
			this.nearPlaneDistance = near;
			this.farPlaneDistance = far;
		}

		public FogType getType() {
			return this.type;
		}

		public float getNearPlaneDistance() {
			return this.nearPlaneDistance;
		}

		public void setNearPlaneDistance(float distance) {
			this.nearPlaneDistance = distance;
		}

		public float getFarPlaneDistance() {
			return this.farPlaneDistance;
		}

		public void setFarPlaneDistance(float distance) {
			this.farPlaneDistance = distance;
		}
	}

	public static class ComputeFogColor extends ViewportEvent {
		private float red;
		private float green;
		private float blue;

		public ComputeFogColor(Camera camera, double partialTick, float red, float green, float blue) {
			super(camera, partialTick);
			this.red = red;
			this.green = green;
			this.blue = blue;
		}

		public float getRed() {
			return this.red;
		}

		public void setRed(float red) {
			this.red = red;
		}

		public float getGreen() {
			return this.green;
		}

		public void setGreen(float green) {
			this.green = green;
		}

		public float getBlue() {
			return this.blue;
		}

		public void setBlue(float blue) {
			this.blue = blue;
		}
	}
}
