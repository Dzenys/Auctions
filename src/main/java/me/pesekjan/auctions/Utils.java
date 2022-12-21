package me.pesekjan.auctions;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.UUID;

public class Utils {

    public static ItemStack getTextureHead(String texture) {
        UUID uuid = UUID.nameUUIDFromBytes(texture.getBytes());
        PlayerProfile profile = Bukkit.getServer().createPlayerProfile(uuid);
        profile.setTextures(new PlayerTexturesImpl(texture));
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        if (meta == null) return skull;
        meta.setOwnerProfile(profile);
        skull.setItemMeta(meta);
        return skull;
    }

    private static class PlayerTexturesImpl implements PlayerTextures {

        private URL textures;

        private PlayerTexturesImpl(String textures) {
            String decoded = new String(Base64.getDecoder().decode(textures));
            try {
                this.textures = new URL(decoded
                        .replace("{\"textures\":{\"SKIN\":{\"url\":\"", "")
                        .replace("\"}}}", "")
                );
            } catch (MalformedURLException ignored) { }
        }

        @Override
        public boolean isEmpty() {
            return textures != null;
        }

        @Override
        public void clear() {
            textures = null;
        }

        @Override
        public URL getSkin() {
            return textures;
        }

        @Override
        public void setSkin(URL url) {
            textures = url;
        }

        @Override
        public void setSkin(URL url, SkinModel skinModel) {
            textures = url;
        }

        @Override
        public SkinModel getSkinModel() {
            return SkinModel.CLASSIC;
        }

        @Override
        public URL getCape() {
            return null;
        }

        @Override
        public void setCape(URL url) {

        }

        @Override
        public long getTimestamp() {
            return 0;
        }

        @Override
        public boolean isSigned() {
            return false;
        }

    }

}
