<%@page import="java.util.List"%>
<%@page import="tn.iit.model.Enseignant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<!-- Coding by CodingNepal || www.codingnepalweb.com -->
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Hoverable Sidebar Menu HTML CSS & JavaScript</title>
<link rel="stylesheet" href="css/style.css" />
<!-- Boxicons CSS -->
<link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
</style>
<script>
	$(document).ready(function() {
		// Activate tooltip
		$('[data-toggle="tooltip"]').tooltip();

		// Select/Deselect checkboxes
		var checkbox = $('table tbody input[type="checkbox"]');
		$("#selectAll").click(function() {
			if (this.checked) {
				checkbox.each(function() {
					this.checked = true;
				});
			} else {
				checkbox.each(function() {
					this.checked = false;
				});
			}
		});
		checkbox.click(function() {
			if (!this.checked) {
				$("#selectAll").prop("checked", false);
			}
		});
	});
	$(document).ready(function() {
		// Add click event listener to the edit button
		$(".editBtn").on("click", function() {
			// Get the enseignant's information from the table row or any other source
			var enseignantId = $(this).data("id");
			var nom = $(this).data("nom");
			var email = $(this).data("email");
			var cin = $(this).data("cin");
			var telephone = $(this).data("telephone");

			// Set the values in the edit form fields
			$("#editEnseignantId").val(enseignantId);
			$("#editEnseignantNom").val(nom);
			$("#editEnseignantEmail").val(email);
			$("#editEnseignantCIN").val(cin);
			$("#editEnseignantTelephone").val(telephone);

			// Show the edit modal dialog
			$("#editEnseignantModal").modal("show");
		});
	});
	$(document).ready(function() {
		// Add click event listener to the edit button
		$(".deleteBtn").on("click", function() {
			// Get the enseignant's information from the table row or any other source
			var enseignantId = $(this).data("id");
			// Set the values in the edit form fields
			$("#deleteEnseignantId").val(enseignantId);
			$("#deleteEnseignantModal").modal("show");
		});
	});
</script>
</head>
<body>
	<nav class="sidebar locked">
		<div class="logo_items flex">
			<span class="nav_image"> <img src="images/logo.png"
				alt="logo_img" />
			</span> <span class="logo_name">Dashboard</span> <i class="bx bx-lock-alt"
				id="lock-icon" title="Unlock Sidebar"></i> <i class="bx bx-x"
				id="sidebar-close"></i>
		</div>

		<div class="menu_container">
			<div class="menu_items">
				<ul class="menu_item">
					<div class="menu_title flex">
						<span class="title">Dashboard</span> <span class="line"></span>
					</div>
					<li class="item"><a href="EnseignantController"
						class="link flex"> <i class="bx bx-home-alt"></i> <span>Enseigant</span>
					</a></li>
					<li class="item"><a href="#" class="link flex"> <i
							class="bx bx-grid-alt"></i> <span>Autorisation</span>
					</a></li>
				</ul>




			</div>

			<div class="sidebar_profile flex">
				<span class="nav_image"> <img src="images/profile.jpg"
					alt="logo_img" />
				</span>
				<div class="data_text">
					<span class="name">David Oliva</span> <span class="email">david@gmail.com</span>
				</div>
			</div>
		</div>
	</nav>

	<!-- Navbar -->
	<nav class="navbar flex">
		<i class="bx bx-menu" id="sidebar-open"></i> <input type="text"
			placeholder="Search..." class="search_box" /> <span
			class="nav_image"> <img src="images/profile.jpg"
			alt="logo_img" />
		</span>
	</nav>
	<div class="container-xl">
		<div class="table-responsive center-table">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-6">
							<h2>
								Gestion <b>Enseignant</b>
							</h2>
						</div>
						<div class="col-sm-6">
							<a href="#addEnseignantModal" class="btn btn-success"
								data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Ajouter
									Nouveau Enseignant</span></a> <a href="#deleteEnseignantModal"
								class="btn btn-danger" data-toggle="modal"><i
								class="material-icons">&#xE15C;</i> <span>Supprimer</span></a>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th><span class="custom-checkbox"> <input
									type="checkbox" id="selectAll"> <label for="selectAll"></label>
							</span></th>
							<th>ID</th>
							<th>Nom</th>
							<th>Email</th>
							<th>CIN</th>
							<th>Telephone</th>
							<th>Actions</th>
						</tr>
					</thead>
					<c:if test="${empty enseignants}">
						<tr>
							<td colspan="6">No enseignants found.</td>
						</tr>
					</c:if>

					<tbody>

						<c:forEach var="enseignant" items="${enseignants}">
							<tr>
								<td><span class="custom-checkbox"> <input
										type="checkbox" id="checkbox1" name="options[]" value="1">
										<label for="checkbox1"></label>
								</span></td>
								<td>${enseignant.getIdEnseignant()}</td>
								<td>${enseignant.getNom()}</td>
								<td>${enseignant.getEmail()}</td>
								<td>${enseignant.getCin()}</td>
								<td>${enseignant.getTelephone()}</td>

								<td><a href="#editEnseignantModal" class="editBtn"
									data-toggle="modal" data-id="${enseignant.getIdEnseignant()}"
									data-nom="${enseignant.getNom()}"
									data-email="${enseignant.getEmail()}"
									data-cin="${enseignant.getCin()}"
									data-telephone="${enseignant.getTelephone()}"> <i
										class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
								</a> <a href="#deleteEnseignantModal" class="deleteBtn"
									data-toggle="modal" data-id="${enseignant.getIdEnseignant()}"> <i class="material-icons"
										data-toggle="tooltip" title="Delete">&#xE872;</i>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="clearfix">
					<div class="hint-text">
						Showing <b>5</b> out of <b>25</b> entries
					</div>
					<ul class="pagination">
						<li class="page-item disabled"><a href="#">Previous</a></li>
						<li class="page-item"><a href="#" class="page-link">1</a></li>
						<li class="page-item"><a href="#" class="page-link">2</a></li>
						<li class="page-item active"><a href="#" class="page-link">3</a></li>
						<li class="page-item"><a href="#" class="page-link">4</a></li>
						<li class="page-item"><a href="#" class="page-link">5</a></li>
						<li class="page-item"><a href="#" class="page-link">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<!-- ADD Modal HTML -->
	<div id="addEnseignantModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="EnseignantController" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Ajouter Enseignant</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<!-- ID field hidden -->
						<div class="form-group">
							<label>Nom</label> <input type="text" name="nom"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Email</label> <input type="email" name="email"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>CIN</label> <input type="text" name="cin"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Telephone</label> <input type="text" name="telephone"
								class="form-control" required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Edit Modal HTML -->
	<div id="editEnseignantModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="UpdateController" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Modifier Enseignant</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<input type="hidden" name="idEnseignant" id="editEnseignantId">

						<div class="form-group">
							<label for="nom">Nom</label> <input type="text"
								class="form-control" id="editEnseignantNom" name="nom">
						</div>
						<div class="form-group">
							<label for="email">Email</label> <input type="email"
								class="form-control" id="editEnseignantEmail" name="email">
						</div>
						<div class="form-group">
							<label for="address">Cin</label> <input type="text"
								class="form-control" id="editEnseignantCIN" name="cin">
						</div>
						<div class="form-group">
							<label for="phone">Telephone</label> <input type="text"
								class="form-control" id="editEnseignantTelephone" name="telephone">
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit" class="btn btn-info"
							value="Save">
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Delete Modal HTML -->
	<div id="deleteEnseignantModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="DeleteController" method="POST">
					<div class="modal-header">
						<h4 class="modal-title">Supprimer Enseignant</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<input type="hidden" name="id" id="deleteEnseignantId">
						<p>Are you sure you want to delete these Records?</p>
						<p class="text-warning">
							<small>This action cannot be undone.</small>
						</p>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-danger" value="Delete">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

</body>
</html>