package com.solano.string;

/**
 * @author github.com/solano33
 * @date 2024/11/3 23:46
 */
public class Test_1 {

    public static void main(String[] args) {
        String s = "{\"log\":\"pipeline/test/multi- slam/216521/exp_map/crowd-data-layer- gen/\n" +
                "test202410311719/5051215015-03003_004392/log/\n" +
                "test202410311719/5051215015-03003_004392/\n" +
                "log\",\"execErr\":\"com.xiaomi.hdmap.commo n.exception.HdmapException:ks3客户端错误:文件为:pipeline/test/multi-slam/216521/exp_map/crowd-data-layer-gen/ test202410311719/5051215015-03003_004392/output/\n" +
                "test202410311719/5051215015-03003_004392/ouput/\n" +
                "scenario5051215015-03003_004392/ traj_filter_res/matched_track_ids.txt，信息为:java.net.SocketException: Connection reset\"}";
        String sSimilar = "{\"log\":\"pipeline/test/multi-slam/216522/exp_map/crowd-data-layer-gen/\n" +
                "test202410311720/5051215015-03004_004393/log/\n" +
                "test202410311720/5051215015-03004_004393/\n" +
                "log\",\"execErr\":\"com.xiaomi.hdmap.commo n.exception.HdmapException:ks3客户端错误:文件为:pipeline/test/multi-slam/216522/exp_map/crowd-data-layer-gen/ test202410311720/5051215015-03004_004393/output/\n" +
                "test202410311720/5051215015-03004_004393/ouput/\n" +
                "scenario5051215015-03004_004393/ traj_filter_res/matched_track_ids.txt，信息为:java.net.SocketException: Connection reset\"}";
        CosineSimilarity similarity = new CosineSimilarity(s, sSimilar);
        System.out.println(similarity.sim());
    }
}
