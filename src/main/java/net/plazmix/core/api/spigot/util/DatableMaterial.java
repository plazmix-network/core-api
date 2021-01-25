package net.plazmix.core.api.spigot.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("deprecation")
public final class DatableMaterial {

    public static DatableMaterial fromString(String str) {
        return new DatableMaterial(str);
    }

    public static String toString(DatableMaterial datableMaterial) {
        return datableMaterial.toString();
    }

    public static DatableMaterial of(Material material) {
        return new DatableMaterial(material, (short) 0);
    }

    public static DatableMaterial of(Material material, short data) {
        return new DatableMaterial(material, data);
    }

    private final Material material;
    private final short data;

    public DatableMaterial(Material material, short data) {
        this.material = material;
        this.data = data;
    }

    public DatableMaterial(int id, short data) {
        this(Material.getMaterial(id), data);
    }

    public DatableMaterial(String str) {
        String[] idData = str.split(":");
        Material material = Material.AIR;
        short data = 0;

        if (!StringUtils.isNumeric(idData[0])) {
            Material hashMaterial = Material.getMaterial(idData[0]);
            if (hashMaterial != null)
                material = hashMaterial;
        } else
            material = Material.getMaterial(Integer.parseInt(idData[0]));

        if (idData.length > 1)
            if (StringUtils.isNumeric(idData[1]))
                data = Short.parseShort(idData[1]);

        this.material = material;
        this.data = data;
    }

    public Material getMaterial() {
        return material;
    }

    public short getData() {
        return data;
    }

    public ItemStack toItemStack() {
        return new ItemStack(material, 1, data);
    }

    @Override
    public String toString() {
        return material.name() + ":" + data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null || !(obj instanceof DatableMaterial))
            return false;

        DatableMaterial datableType = (DatableMaterial) obj;
        return this.material == datableType.material && this.data == datableType.data;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(material).append(data).toHashCode();
    }
}