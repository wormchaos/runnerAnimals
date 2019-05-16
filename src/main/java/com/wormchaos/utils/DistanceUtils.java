package com.wormchaos.utils;

import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.shape.Rectangle;
import com.wormchaos.utils.dto.DisPoint;

import java.util.List;

/**
 * Created by wormchaos on 2019-4-30.
 */
public class DistanceUtils {

    /**
     * 查询坐标点周边的point列表
     * @param point 当前坐标点
     * @param radius 距离单位km
     * @return
     */
    public static List<?> findNearbyDistrictByRadius(DisPoint point, int radius) {
        SpatialContext geo = SpatialContext.GEO;
        Rectangle rectangle = geo.getDistCalc().calcBoxByDistFromPt(geo.makePoint(point.getLon(), point.getLat()),
                radius * com.spatial4j.core.distance.DistanceUtils.KM_TO_DEG, geo, null);
        double minX = rectangle.getMinX();
        double maxX = rectangle.getMaxX();
        double minY = rectangle.getMinY();
        double maxY = rectangle.getMaxY();
        System.out.print(minX + " " + maxX + " "+ minY + " "+ maxY + " ");
//        LOGGER.info(minX + " - " + maxX);   // 经度范围
//        LOGGER.info(minY + " - " + maxY);   // 纬度范围
        String sql = "select * from district where (lon BETWEEN ? AND ?) AND (lat BETWEEN ? AND ?) and level = 'street' ";
//        List<District> districtList = dao.find(sql, minX, maxX, minY, maxY);

//        LOGGER.info("districtList1={}", JSON.toJSONString(districtList));

        //按照距离排序
//        Collections.sort(districtList, new DistrictComparator(lon, lat));

        return null;
    }

    public static void main (String... args) {
        DisPoint point = new DisPoint();
        point.setLat(31.2515000000D);
        point.setLon(121.5073200000D);
        DistanceUtils.findNearbyDistrictByRadius(point, 3);
    }

}
