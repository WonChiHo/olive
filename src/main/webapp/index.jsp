<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>olive ung</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
  	<style type="text/css">

  		.nav-link.active {
    	color: black; /* 검정색으로 설정 */
    	font-weight:bold;
		}
		.nav-link {
		color:black;'
		}
		.nav-item {           
	    margin-left: 160px; /* 왼쪽 여백을 50px로 설정 */
	    margin-right: 200px; /* 오른쪽 여백을 50px로 설정 */
		}

		.nav-item:not(:last-child) {
		    margin-right: 100px;
		}
		
		
  		<%@ include file="css/styles.css" %>
  		
  		
  	</style>
  	<script>

  	</script>
    </head>
<body>
        <!-- Header-->
       <jsp:include page="header.jsp" />
               
        <hr>
        <!--  랭킹, 스킨케어, 메이크업, 향수, 클렌징 bar -->
     	<div id="_container">
		    <ul id="nav4" class="nav justify-content-between">
		       
		        <li class="nav-item">
		            <a class="nav-link active" href="${pageContext.request.contextPath}/ranking/rankingList">랭킹</a>
		        </li>
		
		        <li class="nav-item">
		            <a class="nav-link active" href="${pageContext.request.contextPath}/detail/ShowALLDetailList?List=Skin">스킨케어</a>
		        </li>
		
		        <li class="nav-item">
		            <a class="nav-link active" href="${pageContext.request.contextPath}/detail/ShowALLDetailList?List=Makeup">메이크업</a>
		        </li>
		
		        <li class="nav-item">
		            <a class="nav-link active" href="${pageContext.request.contextPath}/detail/ShowALLDetailList?List=Perfume">향수</a>
		        </li>
		
		        <li class="nav-item">
		            <a class="nav-link active" href="${pageContext.request.contextPath}/detail/ShowALLDetailList?List=Cleansing">클렌징</a>
		        </li>
		    </ul>
		</div>	
        <!-- banner -->
        <div class="banner">
        	<img src = "img/banner.jpg" />
        </div>
        <!-- Related items section-->
         <div class="container">
        	<div class="row gx-md-5">
                <section class="py-5 bg-light" id="container1">
                    <h3 class="fw-bolder mb-4">요즘 주목 받는 상품</h3>
                    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3  justify-content-left">
                        <div class="col-md-6 mb-5">
                            <div class="card h-100">
                                <!-- Product image-->
                                <img class="card-img-top" src="img/skin1.jpg" alt="..." />
                                <!-- Product details-->
                                <div class="card-body p-4">
                                    <div class="text-center">
                                        <!-- Product name-->
                                        <h5 class="fw-bolder">VT 리들샷 100 에센스 50ml</h5>
                                        <!-- Product reviews-->
                                        <div class="d-flex justify-content-center small text-warning mb-2">
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                        </div>
                                        <!-- Product price-->
                                      	32,000원
                                    </div>
                                </div>
                                <!-- Product actions-->
                                <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                    <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="${pageContext.request.contextPath}/detail/detailList?idx=1">View options</a></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 mb-5">
                            <div class="card h-100">
                                <!-- Sale badge-->
                                <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                                <!-- Product image-->
                                <img class="card-img-top" src="img/cleansing3.jpg" alt="..." />
                                <!-- Product details-->
                                <div class="card-body p-4">
                                    <div class="text-center">
                                        <!-- Product name-->
                                        <h5 class="fw-bolder">메이크프렘 세이프 미 <br> 클렌징밀크</h5>
                                        <!-- Product reviews-->
                                        <div class="d-flex justify-content-center small text-warning mb-2">
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                        </div>
                                        <!-- Product price-->
                                        <span class="text-muted text-decoration-line-through">28,000원</span><br>
                                        20,400원
                                    </div>
                                </div>
                                <!-- Product actions-->
                                <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                    <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="${pageContext.request.contextPath}/detail/detailList?idx=12">View options</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                
                <section class="py-5 bg-light" id="container2">
                    <h3 class="fw-bolder mb-4">고객님을 위한 추천 상품</h3>
                    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3  justify-content-left">
                        <div class="col-md-6 mb-5">
                            <div class="card h-100">
                      			<div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                            
                                <!-- Product image-->
                                <img class="card-img-top" src="img/perfume7.jpg" alt="..." />
                                <!-- Product details-->
                                <div class="card-body p-4">
                                    <div class="text-center">
                                        <!-- Product name-->
                                        <h5 class="fw-bolder">필로소피 어메이징그레이스 발레로즈 EDT 60ml</h5>
                                        <!-- Product reviews-->
                                        <div class="d-flex justify-content-center small text-warning mb-2">
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                        </div>
                                        <!-- Product price-->
                                        <span class="text-muted text-decoration-line-through">79,000원</span><br>
                                     	67,100원
                                    </div>
                                </div>
                                <!-- Product actions-->
                                <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                    <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="${pageContext.request.contextPath}/detail/detailList?idx=34">View options</a></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 mb-5">
                            <div class="card h-100">
                                <!-- Sale badge-->
                                <!-- Product image-->
                                <img class="card-img-top" src="img/perfume8.jpg" alt="..." />
                                <!-- Product details-->
                                <div class="card-body p-4">
                                    <div class="text-center">
                                        <!-- Product name-->
                                        <h5 class="fw-bolder">나르시소 로드리게즈 엉브레 EDP 50ml</h5>
                                        <!-- Product reviews-->
                                        <div class="d-flex justify-content-center small text-warning mb-2">
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                        </div>
                                        <!-- Product price-->
                                          <!-- Product price-->
                                      	141,000원
                                    </div>
                                </div>
                                <!-- Product actions-->
                                <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                    <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="${pageContext.request.contextPath}/detail/detailList?idx=35">View options</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
       
        <footer class="py-5 bg-dark">
       		<jsp:include page="footer.jsp" />
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; olive ung  2024</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>