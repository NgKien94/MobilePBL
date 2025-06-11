package com.example.pbl5.utils

import com.example.pbl5.R
import com.example.pbl5.model.TrafficSignInfo


val trafficSignDetails = mapOf(
    "P.102" to TrafficSignInfo(
        R.drawable.sign_p102,
        "Cấm đi ngược chiều",
        "Cấm xe ô tô đi ngược chiều trên đường một chiều hoặc đường cấm. Phạt tiền từ 18.000.000đ đến 20.000.000đ cho tài xế ô tô vi phạm."
    ),
    "P.103a" to TrafficSignInfo(
        R.drawable.sign_p103a,
        "Cấm xe ô tô",
        "Cấm xe ô tô (trừ xe ưu tiên) lưu thông vào khu vực có biển báo. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
//    "P.103b" to TrafficSignInfo(
//        R.drawable.sign_p103b,
//        "Cấm xe ô tô rẽ trái",
//        "Cấm xe ô tô rẽ trái tại giao lộ hoặc khu vực có biển báo. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
//    ),
//    "P.103c" to TrafficSignInfo(
//        R.drawable.sign_p103c,
//        "Cấm xe ô tô rẽ phải",
//        "Cấm xe ô tô rẽ phải tại giao lộ hoặc khu vực có biển báo. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
//    ),
    "P.103b" to TrafficSignInfo(
        R.drawable.sign_p123b,
        "Cấm rẽ phải",
        "Cấm tất cả các loại xe (bao gồm ô tô) rẽ phải tại giao lộ. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "P.103c" to TrafficSignInfo(
        R.drawable.sign_p123a,
        "Cấm rẽ trái",
        "Cấm tất cả các loại xe (bao gồm ô tô) rẽ trái tại giao lộ. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "P.104" to TrafficSignInfo(
        R.drawable.sign_p104,
        "Cấm xe máy",
        "Cấm xe máy lưu thông, không áp dụng cho xe ô tô. Không có phạt trực tiếp cho tài xế ô tô."
    ),
    "P.106a" to TrafficSignInfo(
        R.drawable.sign_p106a,
        "Cấm xe ô tô tải",
        "Cấm xe ô tô tải (trừ xe ưu tiên) lưu thông vào khu vực có biển báo. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "P.106b" to TrafficSignInfo(
        R.drawable.sign_p106b,
        "Cấm ô tô tải có khối lượng chuyên chở lớn hơn giới hạn",
        "Cấm xe ô tô tải vượt quá khối lượng cho phép. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm; có thể lên đến 14.000.000đ nếu gây hậu quả nghiêm trọng."
    ),
    "P.112" to TrafficSignInfo(
        R.drawable.sign_p112,
        "Cấm người đi bộ",
        "Cấm người đi bộ vào khu vực có biển báo, không áp dụng cho xe ô tô. Không có phạt trực tiếp cho tài xế ô tô."
    ),
    "P.115" to TrafficSignInfo(
        R.drawable.sign_p115,
        "Hạn chế trọng lượng xe",
        "Cấm xe ô tô vượt quá trọng lượng cho phép. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm; có thể lên đến 14.000.000đ nếu gây hậu quả nghiêm trọng."
    ),
    "P.117" to TrafficSignInfo(
        R.drawable.sign_p117,
        "Hạn chế chiều cao",
        "Cấm xe ô tô vượt quá chiều cao cho phép. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "P.123a" to TrafficSignInfo(
        R.drawable.sign_p123a,
        "Cấm rẽ trái",
        "Cấm tất cả các loại xe (bao gồm ô tô) rẽ trái tại giao lộ. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "P.123b" to TrafficSignInfo(
        R.drawable.sign_p123b,
        "Cấm rẽ phải",
        "Cấm tất cả các loại xe (bao gồm ô tô) rẽ phải tại giao lộ. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "P.124a" to TrafficSignInfo(
        R.drawable.sign_p124a,
        "Cấm quay đầu xe",
        "Cấm xe ô tô quay đầu tại khu vực có biển báo. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "P.124c" to TrafficSignInfo(
        R.drawable.sign_p124c,
        "Cấm rẽ trái và quay xe",
        "Cấm xe ô tô rẽ trái hoặc quay đầu tại khu vực có biển báo. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "P.125" to TrafficSignInfo(
        R.drawable.sign_p125,
        "Cấm vượt",
        "Cấm xe ô tô vượt xe khác tại khu vực có biển báo. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "P.127" to TrafficSignInfo(
        R.drawable.sign_p127,
        "Tốc độ tối đa cho phép",
        "Giới hạn tốc độ tối đa cho xe ô tô. Phạt tiền từ 800.000đ đến 1.000.000đ nếu vượt dưới 10km/h; 4.000.000đ đến 6.000.000đ nếu vượt 10-20km/h; 12.000.000đ đến 14.000.000đ nếu vượt trên 35km/h."
    ),
    "P.130" to TrafficSignInfo(
        R.drawable.sign_p130,
        "Cấm dừng xe và đỗ xe",
        "Cấm xe ô tô dừng hoặc đỗ tại khu vực có biển báo. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "P.131a" to TrafficSignInfo(
        R.drawable.sign_p131a,
        "Cấm đỗ xe",
        "Cấm xe ô tô đỗ tại khu vực có biển báo. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "P.137" to TrafficSignInfo(
        R.drawable.sign_p137,
        "Cấm rẽ trái và rẽ phải",
        "Cấm xe ô tô rẽ trái hoặc rẽ phải tại giao lộ. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "P.135" to TrafficSignInfo(
        R.drawable.sign_p135,
        "Hết tất cả các lệnh cấm",
        "Báo hiệu kết thúc các lệnh cấm trước đó, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "R.301c" to TrafficSignInfo(
        R.drawable.sign_r301c,
        "Các xe chỉ được rẽ trái",
        "Xe ô tô chỉ được rẽ trái, cấm đi thẳng hoặc rẽ phải. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "R.301d" to TrafficSignInfo(
        R.drawable.sign_r301d,
        "Các xe chỉ được rẽ phải",
        "Xe ô tô chỉ được rẽ phải, cấm đi thẳng hoặc rẽ trái. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "R.301e" to TrafficSignInfo(
        R.drawable.sign_r301e,
        "Các xe chỉ được rẽ trái",
        "Xe ô tô chỉ được rẽ trái, cấm đi thẳng hoặc rẽ phải. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "R.302a" to TrafficSignInfo(
        R.drawable.sign_r302a,
        "Phải đi vòng sang bên phải",
        "Xe ô tô phải đi vòng bên phải theo hướng dẫn. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "R.302b" to TrafficSignInfo(
        R.drawable.sign_r302b,
        "Phải đi vòng sang bên trái",
        "Xe ô tô phải đi vòng bên trái theo hướng dẫn. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "R.303" to TrafficSignInfo(
        R.drawable.sign_r303,
        "Nơi giao nhau chạy theo vòng xuyến",
        "Xe ô tô phải di chuyển theo vòng xuyến. Phạt tiền từ 800.000đ đến 1.000.000đ nếu không tuân thủ hướng dẫn."
    ),
    "R.407a" to TrafficSignInfo(
        R.drawable.sign_r407a,
        "Đường một chiều",
        "Xe ô tô đi ngược chiều trên đường một chiều bị cấm. Phạt tiền từ 18.000.000đ đến 20.000.000đ cho tài xế ô tô vi phạm."
    ),
    "R.409" to TrafficSignInfo(
        R.drawable.sign_r409,
        "Chỗ quay xe",
        "Chỉ dẫn chỗ quay xe cho phép, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "R.425" to TrafficSignInfo(
        R.drawable.sign_r425,
        "Bệnh viện",
        "Biển thông báo vị trí bệnh viện, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "R.434" to TrafficSignInfo(
        R.drawable.sign_r434,
        "Bến xe buýt",
        "Cấm xe ô tô dừng/đỗ trái phép tại khu vực bến xe buýt. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "S.509a" to TrafficSignInfo(
        R.drawable.sign_s509a,
        "Chiều cao an toàn",
        "Cấm xe ô tô vượt quá chiều cao an toàn cho phép. Phạt tiền từ 800.000đ đến 1.000.000đ cho tài xế ô tô vi phạm."
    ),
    "W.201a" to TrafficSignInfo(
        R.drawable.sign_w201a,
        "Chỗ ngoặt nguy hiểm vòng bên trái",
        "Cảnh báo khúc cua nguy hiểm bên trái, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "W.201b" to TrafficSignInfo(
        R.drawable.sign_w201b,
        "Chỗ ngoặt nguy hiểm vòng bên phải",
        "Cảnh báo khúc cua nguy hiểm bên phải, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "W.202a" to TrafficSignInfo(
        R.drawable.sign_w202a,
        "Nhiều chỗ ngoặt nguy hiểm liên tiếp, chỗ đầu tiên sang trái",
        "Cảnh báo nhiều khúc cua nguy hiểm, bắt đầu sang trái, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "W.202b" to TrafficSignInfo(
        R.drawable.sign_w202b,
        "Nhiều chỗ ngoặt nguy hiểm liên tiếp, chỗ đầu tiên sang phải",
        "Cảnh báo nhiều khúc cua nguy hiểm, bắt đầu sang phải, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "W.203b" to TrafficSignInfo(
        R.drawable.sign_w203b,
        "Đường bị thu hẹp về phía trái",
        "Cảnh báo đường hẹp bên trái, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "W.203c" to TrafficSignInfo(
        R.drawable.sign_w203c,
        "Đường bị thu hẹp về phía phải",
        "Cảnh báo đường hẹp bên phải, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "W.205a" to TrafficSignInfo(
        R.drawable.sign_w205a,
        "Đường giao nhau (ngã tư)",
        "Cảnh báo ngã tư giao nhau, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "W.205b" to TrafficSignInfo(
        R.drawable.sign_w205b,
        "Đường giao nhau (ngã ba bên trái)",
        "Cảnh báo ngã ba giao nhau bên trái, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "W.205d" to TrafficSignInfo(
        R.drawable.sign_w205d,
        "Đường giao nhau (hình chữ T)",
        "Cảnh báo giao lộ hình chữ T, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "W.207a" to TrafficSignInfo(
        R.drawable.sign_w207a,
        "Giao nhau với đường không ưu tiên",
        "Cảnh báo giao lộ với đường không ưu tiên, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "W.207b" to TrafficSignInfo(
        R.drawable.sign_w207b,
        "Giao nhau với đường không ưu tiên bên phải",
        "Cảnh báo giao lộ với đường không ưu tiên bên phải, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "W.207c" to TrafficSignInfo(
        R.drawable.sign_w207c,
        "Giao nhau với đường không ưu tiên bên trái",
        "Cảnh báo giao lộ với đường không ưu tiên bên trái, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "W.208" to TrafficSignInfo(
        R.drawable.sign_w208,
        "Giao nhau với đường ưu tiên",
        "Cảnh báo giao lộ với đường ưu tiên, yêu cầu nhường đường. Phạt tiền từ 800.000đ đến 1.000.000đ nếu không nhường đường cho xe trên đường ưu tiên."
    ),
    "W.209" to TrafficSignInfo(
        R.drawable.sign_w209,
        "Giao nhau có tín hiệu đèn giao thông",
        "Cảnh báo giao lộ có đèn giao thông. Phạt tiền từ 18.000.000đ đến 20.000.000đ nếu vượt đèn đỏ; 800.000đ đến 1.000.000đ nếu vượt đèn vàng (trừ trường hợp đã qua vạch dừng)."
    ),
    "W.210" to TrafficSignInfo(
        R.drawable.sign_w210,
        "Giao nhau với đường sắt có rào chắn",
        "Cảnh báo giao lộ với đường sắt có rào chắn. Phạt tiền từ 800.000đ đến 1.000.000đ nếu không dừng hoặc vượt rào chắn khi đang đóng."
    ),
    "W.219" to TrafficSignInfo(
        R.drawable.sign_w219,
        "Dốc xuống nguy hiểm",
        "Cảnh báo đoạn đường dốc xuống nguy hiểm, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "W.221b" to TrafficSignInfo(
        R.drawable.sign_w221b,
        "Đường có gồ giảm tốc",
        "Cảnh báo đoạn đường có gờ giảm tốc, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "W.224" to TrafficSignInfo(
        R.drawable.sign_w224,
        "Đường người đi bộ cắt ngang",
        "Cảnh báo khu vực người đi bộ qua đường. Phạt tiền từ 4.000.000đ đến 6.000.000đ nếu không nhường đường cho người đi bộ."
    ),
    "W.225" to TrafficSignInfo(
        R.drawable.sign_w225,
        "Trẻ em",
        "Cảnh báo khu vực có trẻ em qua đường. Phạt tiền từ 800.000đ đến 1.000.000đ nếu không giảm tốc độ hoặc không nhường đường."
    ),
    "W.227" to TrafficSignInfo(
        R.drawable.sign_w227,
        "Công trường",
        "Cảnh báo khu vực công trường, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "W.233" to TrafficSignInfo(
        R.drawable.sign_w233,
        "Nguy hiểm khác",
        "Cảnh báo nguy hiểm chung, không áp dụng phạt trực tiếp cho tài xế ô tô."
    ),
    "W.245a" to TrafficSignInfo(
        R.drawable.sign_w245a,
        "Đi chậm",
        "Yêu cầu xe ô tô giảm tốc độ. Phạt tiền từ 800.000đ đến 1.000.000đ nếu không giảm tốc độ phù hợp."
    )
)